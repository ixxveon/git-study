

export default function Q5_EvenPage({nums}) {
    return (
        <>
            {
                nums
                    .filter(num => num % 2 === 0)
                    .map((num,index) => {
                        return <p>{num}</p>
                    })
            }
        </>
    )
}