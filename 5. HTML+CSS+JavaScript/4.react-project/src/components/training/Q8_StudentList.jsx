

export default function Q8_StudentList({students}) {
    return (
        <>
            {
                students.map((student, index) => {
                    return <p key={index}>{student.name} - {student.score}점</p>
                })
            }
        </>
    )
}