import Header from "../components/Header";
import { useState, useRef, useEffect } from "react";
import { useNoticeDetailQuery } from "../query/NoticeDetailQuery";
import { useParams } from "react-router-dom";
import { useQuillEditorHook } from "../hooks/useQuillEditorHook";
import { useNoticeEditMutation } from "../query/NoticeEditMutation";
import { Link } from "react-router-dom";


export default function NoticeEdit() {

    const { id } = useParams();
    const postId = id ? parseInt(id, 10) : null;
    // 게시글 조회해와야 수정 가능함

    const { data, isLoading, isError, error } = useNoticeDetailQuery(postId);

    const { quillRef, editorReady } = useQuillEditorHook();
    const contentLoadedRef = useRef(false);
    const editorInitializedRef = useRef(false);

    const noticeEditMutation = useNoticeEditMutation();

    console.log("editorReady:", editorReady);
    console.log("quillRef.current:", quillRef.current);

    // API 데이터가 로드되고 에디터가 초기화되면 내용 로드
    useEffect(() => {
        if (editorReady && quillRef.current && data && data.content && !contentLoadedRef.current) {
            try {
                const content = data.content || '';
                if (content.trim()) {

                    quillRef.current.clipboard.dangerouslyPasteHTML(content);
                    contentLoadedRef.current = true;
                    console.log('[NoticeEdit] 게시글 내용을 에디터에 로드 완료');
                }
            } catch (err) {
                console.error('[NoticeEdit] 내용 로드 실패:', err);
            }
        }
    }, [data, editorReady]); // boardDTO와 에디터 초기화 상태가 준비되면 실행


    // 게시글 수정 
    const handleSubmit = (e) => {
        console.log("수정 버튼 눌림");
        e.preventDefault();
        const content = quillRef.current.root.innerHTML; // 내용 가져오기

        const formData = new FormData();
        formData.append("title", title);
        formData.append("content", content);
        formData.append("category", category);

        selectedFiles.forEach(file => {
            formData.append("files", file);
        })

        // API 요청
        noticeEditMutation.mutate({ postId, formData });
    }

    // 로딩 중일 때
    if (isLoading) {
        return (
            <>
                <Header />
                <div className="container">
                    <div style={{ textAlign: 'center' }}>로딩중...</div>
                </div>
            </>
        )
    }

    // 에러가 발생했을 때
    if (isError) {
        return (
            <>
                <Header />
                <div className="container">
                    <div style={{ textAlign: 'center' }}>알 수 없는 오류가 발생했습니다.</div>
                </div>
            </>
        )
    }

    // 존재하지 않는 게시글일 때
    if (!data) {
        return (
            <>
                <Header />
                <div className="container">
                    <div style={{ textAlign: 'center' }}>게시글을 찾을 수 없습니다.</div>
                </div>
            </>
        )
    }


    return (
        <>
            <Header />

            <div className="container">
                <h1 style={{ marginBottom: "2rem" }}>공지사항 수정</h1>
                <div className="form-card" style={{ maxWidth: 800 }}>
                    <form onSubmit={handleSubmit}>
                        <div className="form-group">
                            <label>분류</label>
                            <select
                                id="announcementCategory"
                                onChange={(e) => setCategory(e.target.value)}
                                style={{
                                    width: "100%",
                                    padding: "0.75rem",
                                    border: "1px solid var(--border)",
                                    borderRadius: "0.5rem"
                                }}
                            >
                                <option value="공지">공지</option>
                                <option value="점검">점검</option>
                                <option value="이벤트">이벤트</option>
                            </select>
                        </div>
                        <div className="form-group">
                            <label>제목</label>
                            <input
                                value={data.title}
                                type="text"
                                id="announcementTitle"
                                placeholder="공지사항 제목을 입력하세요"
                                required=""
                                onChange={(e) => setTitle(e.target.value)}
                            />
                        </div>
                        <div className="form-group">
                            <label>내용</label>
                            <div id="noticeEditor" className="editor-container" />
                        </div>
                        <div className="form-group">
                            <label>이미지 업로드</label>
                            <input type="file" id="announcementImage" accept="image/*" />
                            <div id="imagePreview" style={{ marginTop: "1rem" }} />
                        </div>
                        <div className="form-actions" style={{ textAlign: "center" }}>
                            <button type="submit"
                                className="btn btn-primary">
                                수정
                            </button>
                            <Link
                                to="/notice/list"
                                className="btn btn-secondary"
                                style={{ textDecoration: "none" }}
                            >
                                취소
                            </Link>
                        </div>
                    </form>
                </div>
            </div>

        </>
    )
}