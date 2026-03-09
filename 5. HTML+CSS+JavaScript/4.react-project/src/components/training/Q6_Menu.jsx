

export default function Q6_Menu({menus}) {
    return (
        <ul>
            {
                menus.map((menu,index) => {
                    return <li key={index}>{menu}</li>
                })
            }
        </ul>
    )
}