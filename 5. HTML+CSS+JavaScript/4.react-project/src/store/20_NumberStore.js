import { create } from "zustand"

// state: 현재 상태
// numbers:[...state.numbers, num]
// - numbers에 배열을 넣음
// ...state.numbers: 배열 요소 하나하나 풀어서 새로운 배열에 넣음 
// num: 새로운 배열 뒤에 num값을 넣음
// 즉 요소 추가
const useNumberStore = create((set) => ({
    numbers: [],
    addNumber: (num) => set((state) => ({numbers:[...state.numbers, num]})),
    removeNumber: (removeIndex) => set((state) => ({
        numbers: state.numbers.filter((_,index) => index !== removeIndex) // 삭제할 요소만 필터링 됨(삭제한 요소만 삭제돼서 보임)
    }))
}))

export default useNumberStore;