
function login() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    if (email === "hong@example.com" && password === "qwer1234") {
        alert("로그인 성공!");


        location.href = "users-list.html"
    } else {
        alert("이메일 또는 비밀번호가 올바르지 않습니다.");
    }
}
