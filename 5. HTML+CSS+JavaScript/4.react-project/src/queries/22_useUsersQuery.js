import { useQuery } from "@tanstack/react-query";
import { getUser } from "../api/22_Axiox";

export default function useUsersQuery(enabled) {
    return useQuery({
        queryKey: ['users'], // 해당 쿼리의 캐시 키 (식별자)
        queryFn: getUser, // 실제 API 요청을 수행하는 함수
        enabled, // true면 쿼리 실행, false가 오면 useQuery실행 ㄴ -> 오류
        select: (data) => { // 응답 받은 데이터 후처리
            return data.map((user) => ({
                        id: user.id,
                        name: user.name.toLowerCase()
                    }))
        }
    })
} 