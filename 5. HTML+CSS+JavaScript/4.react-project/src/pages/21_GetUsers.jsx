import { useEffect } from "react"
import { getUser } from "../api/21_Axios";
import { useState } from "react";

export default function GetUsers() {
    const [users, setUsers] = useState([]);

    // 컴포넌트가 화면에 나타난 뒤 실행되는 함수
    // 화면 먼저 그림 (render)
    // 그 다음 추가 작업 실행 (즉, 추가 작업 하는 곳)
    // 대표적으로 하는 작업 (API 요청, 데이터 가져오기. 이벤트 등록, 방문 로그 기록)
    useEffect(() => {
        const fetchUser = async () => {
            const data = await getUser();
            setUsers(data);
        }

        fetchUser();
    })
    return (
        // 렌더링 먼저
        <>
            <h2>사용자 목록</h2>
            
            <ul> 
                {users.map((user) => (
                    <li key={user.id}>{user.name}</li>
                ))}
            </ul>
        </>
    )
}