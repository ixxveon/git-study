

export default function Q9_Result({student}) {
    return (
        <>
            {student.score >= 60 ? <h3>{student.name} - 합격</h3> : <h3>{student.name} - 불합격</h3>} 
        </>
    )
}