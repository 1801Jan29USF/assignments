export class Reimbursement {
    amount: number;
    submitted: Date;
    resolved: Date;
    description: String;
    author: String;
    resolver: String;
    status: String;
    type: String;
    id: number;
    constructor(amount: number = 0, submitted: Date = new Date(),
        resolved: Date = new Date(), description: string = '', author: string = '',
        resolver: string = '', status: String = '', type: string = '', id: number = 0) {
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.author = author;
        this.resolver = resolver;
        this.status = status;
        this.type = type;
        this.id = id;
    }
}
