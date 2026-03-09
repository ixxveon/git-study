import { useState } from "react";

export default function MultipleState() {
    const [name, setName] = useState('김재섭');
    const [age, setAge] = useState(19);
    const [isClick, setIsClick] = useState(false);


    // function UpdateName() {
    //     setName('홍길동')
    // }

    return (
        <>
            <p>이름 : {name}</p>
            <p>나이 : {age}</p>
            <button onClick={() => setName('홍길동')}>이름 변경</button>
            <button onClick={() => setAge(20)}>나이 변경</button>
            <button onClick={() => setIsClick(!isClick)}>
                {isClick ? '메시지 숨기기' : '메시지 보기'}
            </button>
        </>
    )
}