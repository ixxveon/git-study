

export default function Q4_FruitList({fruits}) {
    return (
        <ul>
            { fruits.map((fruit, index) => {
                    return <li key={index}>{fruit}</li>
                })
            }
        </ul>
    )
}