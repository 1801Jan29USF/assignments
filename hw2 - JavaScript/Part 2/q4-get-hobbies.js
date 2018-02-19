function getHobbies() {
    let hobbies = document.getElementsByName('hobbies')[0];
    for (let i = 0; i < hobbies.length; i++) {
        if (hobbies[i].selected === true) {
            console.log(hobbies[i].innerText);
        }
        
    }
}

// function getSkills() {
//     let skills = document.getElementsByName('skills')[0];
//     for (let i = 0; i < skills.length; i++) {
//         if (skills[i].selected === true) {
//             console.log(skills[i].innerText);
//         }
        
//     }
// }