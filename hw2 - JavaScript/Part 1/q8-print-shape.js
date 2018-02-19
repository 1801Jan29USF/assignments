function printShape(shape, height, character) {
    switch (shape) {
        case 'Square':
            let line = Array(height + 1).join(character);
            console.log(Array(height + 1).join(line+'\n'));
            break;

        case 'Triangle':
            for (let i = 1; i <= height; i++) {
                let row = '';
                for (let join = 0; join < i; join++) {
                    row = `${character}`;
                }
                console.log(Array(i+1).join(row));
            }
            break;

        case 'Diamond':
            let rows = [];
            let midRow = Array(height + 1).join(character);
            diamondRow(height, character);
            revDiamondRow(height, character);
            break;

        default:
            break;
    }
}

function diamondRow(height, character) {
    for (let i = 1; i < height; i+=2) {
        let line = ' '.repeat((height-i)/2);
        line = line + `${character}`.repeat(i);
        line = line + ' '.repeat((height-i)/2);
        console.log(line);
    }
}

function revDiamondRow(height, character) {
    for (let i = height; i > 0; i-=2) {
        let line = ' '.repeat((height-i)/2);
        line = line + `${character}`.repeat(i);
        line = line + ' '.repeat((height-i)/2);
        console.log(line);
    }
}