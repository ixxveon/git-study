

export default function Q7_Message() {
    let isClick = false;
    let msg = '안녕하세요';

    function MsgChange() {
        isClick = true;
        if(isClick) {
            msg = '반갑습니다';
        }
    }
    

    return (
        <>
            <button onClick={MsgChange}>클릭</button>
            <p>{msg}</p>
        </>
    )
}