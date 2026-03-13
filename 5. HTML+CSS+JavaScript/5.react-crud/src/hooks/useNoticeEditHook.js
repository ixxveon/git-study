import { useNavigate } from "react-router-dom";
import { useNoticeEditMutation } from "../query/NoticeEditMutation"

export const useNoticeEditHook = () => {
    const noticeEditMutation = useNoticeEditMutation();
    const navigate = useNavigate();

    const confirmEdit = () => {
        noticeEditMutation.mutate(postId);
        alert("게시글이 수정되었습니다.");
        navigate("/notice/list");
    }

    return (
        confirmEdit
    )
    
}