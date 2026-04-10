from pydantic import BaseModel
# <CalcRequest> dto
# 파일명: calc_request / 클래스명: CalcRequest
# 1. 총 3개의 타입을 검사
# - a. b: int 타입이어야 함. (사용자가 입력한 숫자 2개)
# - op: str 타입이어야 함. (사용자가 입력한 연산자, "+", "-", "*")
# 요청값 총 a, b, op 3개
class CalcRequest(BaseModel):
    a: int
    b: int
    op: str
