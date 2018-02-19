let hw = document.getElementById('helloWorld');
hw.addEventListener('click', () => {
    setTimeout(() => { hw.style.color = '#'+Math.random().toString(16).substr(-6); }, 3000);
});