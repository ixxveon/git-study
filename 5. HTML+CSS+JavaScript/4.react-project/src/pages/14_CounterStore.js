import { create } from "zustand";

// set : setter
// count : 변수명
// increase : 사용할 함수명
const useCounterStore = create ((set) => ({
    count: 0,
    increase: () => set((state) => ({count: state.count+1})) // setCount((count) => count + 1)
}))

export default useCounterStore;