import { useMutation } from "@tanstack/react-query";
import { useNavigate } from "react-router-dom"
import { noticeDeleteApi } from "../api/boardApi";


export const useNoticeDeleteMutation = () => {
    const navigate = useNavigate();

    return useMutation({
        mutationFn: (postId) => noticeDeleteApi(postId),
        onSuccess: () => {
            alert("게시글이 삭제되었습니다.");
            navigate('/notice/list');
        },
        onError: () => {
            alert("게시글 삭제 요청 중 오류가 발생했습니다.");
        }
    })
}