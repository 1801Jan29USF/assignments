export class ReimbursementType {
    id: number;
    type: string;

    constructor(id: number = 0, type: string = '') {
        this.id = id;
        this.type = type;
    }
}
