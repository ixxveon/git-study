import { useQuery } from "@tanstack/react-query"
import { noticeListApi } from "../api/boardApi"

export const useNoticeListQuery = (page = 1) => {

    return useQuery({
        queryKey: ['noticeList', page], // page: 인덱스 역할 
        queryFn: () => noticeListApi(page), // 함수 이름만 적는 경우: 값이 없을때 // 람다식 쓰는 경우: 값이 있을 때
        staleTime: 30000, // 30초간 유지
        retry: 1
    })
}