from fastapi import APIRouter

router = APIRouter(prefix="/q1")

@router.get("/convert/{value}")
def convert(value: str):
    # value가 숫자냐
    # - "abc": False
    # - "123": True
    if value.isdigit():
        # 형변환
        # - "123" > 123으로 변환
        num = int(value)
        return {"result": num*num}
    else:
        return {"result": value.upper()}

# 1. URL: /hello/김재섭 (GET)
# 2. 받는 값은 항상 문자열
# 3. 반환 타입은 아래와 같다.
# {
#       "success": True,
#       "data": "Hello, [받은값]"
# }


@router.get("/hello/{name}")
def hello(name: str):
    return {
            "success": True,
            "data": f"Hello, {name}"
            }

# 1. URL: /users (GET)
# 2. 사용자 나이를 입력 받음 (정수형)
# 3. 입력받은 나이보다 나이가 많은 유저만 반환
# 4. 반환 값은 아래와 같다. (사용자가 19를 입력할 경우 19세 이상만 반환)
# [
#   {"name": "김재섭", "age": 19},
#   {"name": "홍길동", "age": 22}
# ]
users = [
    {"name": "김재섭", "age": 19},
    {"name": "홍길동", "age": 22},
    {"name": "짱구", "age": 5},
]

@router.get("/users/{age}")
def users(age: int = 0):
    # result = []
    # for user in users:
    #     if user["age"] >= age:
    #         return result.append(user)
    #
    # return result
    return [user for user in users if user["age"] >= age]
