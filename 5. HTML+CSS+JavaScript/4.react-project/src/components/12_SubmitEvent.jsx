import { useState } from "react";

export default function SubmitEvent() {
    const [formData, setFormData] = useState({});

    function handleSubmit(e) {
        e.preventDefault();
        
        setFormData({
            name: e.target.name.value,
            email: e.target.email.value
        });
    }

    console.log(formData);
    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="name" placeholder="Submit 이름"/><br />
            <input type="text" name="email" placeholder="Submit 이메일"/><br />
            <button type="submit">제출</button><br />
        </form>
    )
}