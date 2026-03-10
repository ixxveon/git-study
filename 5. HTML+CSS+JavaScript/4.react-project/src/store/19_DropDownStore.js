import { create } from "zustand";

const useDropDownStore = create ((set) => ({
    selectOption: '',
    setSelectOption: (value) => set({selectOption: value}) 
}))

export default useDropDownStore;