import { useState } from "react"

export default function ObjectState() {
    // 객체 초기 값 설정
    const [user, setUser] = useState({name:"김재섭", age:22})

    function updateName() {
        // 기존 객체를 유지하고 특정 속성을 변경하는 방식
        // - prevUser : 이전 State (매개변수 부분)
        // - ...prevUser : 기존 객체 복사
        // - name: "홍길동" : 해당 객체의 name 값 변경
        setUser(prevUser => ({ ...prevUser, name:"홍길동"}))

        // user.name = "홍길동"; 
        // setUser(user); // 렌더링 안함 그래서 변경 x 새로운 객체를 넣어줘야 변경됨
    }

    return (
        <>
            <div>
                <p>이름 : {user.name}</p>
                <p>나이 : {user.age}</p>
                <button onClick={updateName}>이름 업데이트</button>
            </div>
        </>
    )
}