let skills = document.getElementsByName('skills')[0];
skills.onchange = function (onchangeSkills) {alertSkills()};
skills.dispatchEvent(onchangeAddNums);
let onchangeSkills = new Event('onchange');

function alertSkills() {
    for (let i = 0; i < skills.length; i++) {
        if (skills[i].selected === true) {
            alert(`Are you sure ${skills.value} is one of your skills?`);
        }
        
    }
}