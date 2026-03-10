import useGugudanStore from "../../store/training/Q10_GugudanStore"

export default function Gugudan() {
    const {a, b, useAnswer, result, setA, setB, setUserAnswer} = useGugudanStore();
   
    return(
        <>
            <div>
                <label htmlFor="number1">첫번째 수 (a): </label>
                {/* 이벤트 발생했을 때 입력값 a가져와서 setA에 넣음 */}
                <input type="number" id="number1" value={a} onChange={(e) => setA(e.target.value)}/> 
            </div>
            <div>
                <label htmlFor="number2">두번째 수 (b): </label>
                <input type="number" id="number2" value={b} onChange={(e) => setB(e.target.value)}/>
            </div>
            <p>
                {/* 문제 a x b = ? 형식으로 보여야 함 */}
                {/* a가 비워져 있을 때 '_' 발생 */}
                문제: {a || '_'} x {b || '_'} = ?
            </p>
            
            {/* 값이 들어 왔을 때 입력 값 가져와서 setUserAnswer에 넣음 */}
            <input type="number" onChange={(e) => setUserAnswer(e.target.value)}/>
            <button>정답 확인</button>
            <button style={{marginLeft: '10px'}}>초기화</button>

            {/* 
                사용자가 입력한 숫자가 정답일 경우 '정답 입니다!' 출력
                정답이 아닐 경우 '오답 입니다!' 출력
            */}

          
                <p style={{marginTop: '10px'}}>{status} 입니다!</p>
         
        </>
    )
}