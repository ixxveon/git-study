import { useMutation, useQueryClient } from "@tanstack/react-query"
import { useNavigate } from "react-router-dom";
import { noticeEditApi } from "../api/boardApi";

export const useNoticeEditMutation = () => {
    const navigate = useNavigate();
    const queryClient = useQueryClient();

    return useMutation ({
        mutationFn: ({postId, formData}) => noticeEditApi(postId, formData),
        onSuccess: () => {
            queryClient.invalidateQueries({queryKey: ['noticeList']});
            alert("게시글 수정이 완료되었습니다.");
            navigate("/notice/list");
        },
        onError: () => {
            alert("게시글 수정 요청 중 오류가 발생했습니다.");
        }
    })
}