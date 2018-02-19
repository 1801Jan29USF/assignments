function startTime() {
    let time = new Date();
    let ampm = 'AM';
    if (time.getHours() < 12) { ampm = AM } else { ampm = 'PM'}
    let h = time.getHours() % 12;
    if (h === 0) { h = 12 };
    let m = time.getMinutes();
    if (m < 10) { m = "0" + m };
    let s = time.getSeconds();
    if (s < 10) { s = "0" + s };
    document.getElementById('currentTime').innerHTML = h + ":" + m + ":" + s + " " + ampm;
    setTimeout(() => { startTime() }, 0); // why does 0 work? when just calling fills the stack
    // startTime();
}
startTime();