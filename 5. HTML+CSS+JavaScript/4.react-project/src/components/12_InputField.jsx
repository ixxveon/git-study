import { useState } from "react";

export default function InputFeild() {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');

    function handlerName(e) {
        console.log(e);
        setName(e.target.value);
        console.log(name);
    }

    // function handlerEmail(e) {
    //     setEmail(e.target.value);
    //     console.log(email);
    // }

    return (
        <form action="">
            <input type="text" onChange={handlerName} placeholder="Input 이름"/><br />
            <input type="text" onChange={(e) => {
                setEmail(e.target.value);
                console.log(email);
            }} placeholder="Input 이메일"/>
        </form>
    )
}