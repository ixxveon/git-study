

export default function Q3_LoginStatus({isLogin}) {
    return (
        <>
            {isLogin ? <h3>로그인 성공</h3> : <h3>로그인 필요</h3>}
        </>
    )
}