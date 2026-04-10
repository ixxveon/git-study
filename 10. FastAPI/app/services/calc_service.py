

# <CalcService>
#  파일명: calc_service / 클래스명: CalcService
# 1. calculate 메서드 생성
# - 연산자 조건 검사
#   > 사용자가 요청한 연산자가 "+"일 경우 a+b 반환
#   > 사용자가 요청한 연산자가 "-"일 경우 a-b 반환
#   > 사용자가 요청한 연산자가 "*"일 경우 a*b 반환
#   > 사용자가 요청한 연산자가 "/"일 경우 a/b 반환
class CalcService:
    def calculate(self, a: int, b: int, op: str):
        if op == '+':
            return a + b
        elif op == '-':
            return a - b
        elif op == '*':
            return a * b
        elif op == '/':
            return a / b

