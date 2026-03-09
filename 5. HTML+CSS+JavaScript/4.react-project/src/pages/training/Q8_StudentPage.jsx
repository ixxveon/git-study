import Q8_StudentList from "../../components/training/Q8_StudentList"

export default function StudentPage() {
    return (
        <Q8_StudentList students={[
                                    {name : "김학생", score : 90},
                                    {name : "이학생", score : 80}
        ]}></Q8_StudentList>
    )
}