import { useQuery } from "@tanstack/react-query";
import { getUser } from "../api/22_Axiox";

// getUser : API 요청 함수
// Axios : 서버에서 데이터 가져오는 도구
// Tanstack Query : API 데이터를 관리하는 도구
// enabled: 조건부 실행
// select: 데이터 가공
// retry: 재시도 횟수
export default function useUsersQuery(enabled) {
    return useQuery({
        queryKey: ['users'], // 해당 쿼리의 캐시 키 (식별자)
        queryFn: getUser, // 실제 API 요청을 수행하는 함수 (axios로 요청)
        enabled, // true면 쿼리 실행, false가 오면 useQuery실행 ㄴ -> 오류
        // select: (data) => { // 응답 받은 데이터 후처리
        //     return data.map((user) => ({
        //                 id: user.id, // 캐싱된 데이터 보여줌
        //                 name: user.name.toLowerCase()
        //             }))
        // },
        retry: (failCount, error) => {
            // 첫번째 매개변수(failCount): 실패 횟수  
            // 두번째 매개변수(error): 애러 정보
            
            // ?의 의미: 옵셔널 체이닝
            // - 객체가 없을 때(null, undefined) 에러가 발생하는 것을 방지
            // - 객체가 비워져 있으면 바로 undefined 반환
            const status = error?.response?.status;

            // 응답받은 상태코드가 400~500번이면 retry 하지 않겠다.
            if(status >= 400 && status < 500) return false;

            return failCount < 2;

        },
        // 브라우저 포커스 복귀 시 자동 재시도 방지
        refetchOnWindowFocus: false, 
        staleTime: 1000 * 60 * 5,
        cacheTime: 100 * 60 * 10
    })
} 