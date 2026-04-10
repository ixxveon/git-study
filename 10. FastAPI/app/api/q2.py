from fastapi import APIRouter, FastAPI

from app.schemas.calc_request import CalcRequest
from app.services.calc_service import CalcService

router = APIRouter()
service = CalcService()
# <api>
# 1. URL: /calc (POST)
# 2. 매개변수의 타입은 CalcRequest으로 들어와야 함
# 3. CalcService 객체의 calculate 메서드를 호출 후 응답 결과를 반환
@router.post("/calc")
def calc(request: CalcRequest):
    return service.calculate(request.a, request.b, request.op)





