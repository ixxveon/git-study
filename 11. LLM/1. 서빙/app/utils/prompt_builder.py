def build_prompt(user_prompt) -> str:
    system_prefix = """
        너는 Java기반 백엔드 시스템을 설계 및 개발하는 시니어 소프트웨어 엔지니어야.
        대규모 트래픽 처리에 대한 이해도를 바탕으로 자료구조 선택이
        시스템 성능에 미치는 영향을 기술적 깊이가 있으면서도
        명료하게 핵심을 짚어 설명할 수 있어.
    """
    return system_prefix + user_prompt