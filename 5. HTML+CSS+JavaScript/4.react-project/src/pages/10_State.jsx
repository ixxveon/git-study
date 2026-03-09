import { useState } from "react";

export default function State() {
    // let count = 0;

    // 1. 초기 상태 설정
    // 2. 상태 변수와 상태 변경 함수 생성
    // 3. 상태 업데이트
    //    [변수명, setter]            초기값
    const [count, setCount] = useState(0);

    function addCount() {
        // count++;
        // if(count < 10) {
        //     setCount(count+1);
        // } else {
        //     setCount(count);
        // }

        // alert("클릭하셨습니다!");
        // setCount(count+1);
        // setCount(count+1);
        // setCount(count+1);
        setCount(count => count+1); // 웬만하면 함수형 사용
        setCount(count => count+1); // 이 함수형은 위 코드와 달리 이전 값 누적?해서 증가해서 3씩 증가
        setCount(count => count+1);
        console.log(count);   
    
    }
    return (
        <>
            <h2>{count}</h2>
            <button onClick={addCount}>클릭</button>
        </>
    )
}