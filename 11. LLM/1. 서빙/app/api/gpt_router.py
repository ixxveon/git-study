from fastapi import APIRouter
from app.service.gpt_service import GPTService
from app.schemas.gpt_schema import GPTResponse, GPTRequest

router = APIRouter(prefix="/gpt", tags=["GPT"])

service = GPTService()
@router.post("/generate", response_model=GPTResponse)
def generate_text(req: GPTRequest):

    result = service.generate_text(
        genre = req.genre,
        purpose = req.purpose,
        level = req.level,
        description = req.description,
        max_completion_tokens = req.max_completion_tokens,
        temperature = req.temperature
    )

    return GPTResponse(result=result)
