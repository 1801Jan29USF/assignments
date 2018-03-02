export class Reimbursement {
    id: number;
    amount: number;
    submitted: Date;
    resolved: Date;
    description: string;
    authorId: number;
    author: string;
    resovlerId: number;
    resolver: string;
    statusId: number;
    status: string;
    typeId: number;
    type: string;

    constructor(id: number = 0, amount: number = 0, submittedDte: Date = new Date(), resolved: Date = new Date(),
        description: string = '', authorId = 0, author: string = '', resolverId = 0, resolver: string = '',
        statusId = 0, status: string = '', typeId: number = 0, type: string = '') {
        this.id = id;
        this.amount = amount;
        this.submitted = submittedDte;
        this.resolved = resolved;
        this.description = description;
        this.authorId = authorId;
        this.author = author;
        this.resovlerId = resolverId;
        this.resolver = resolver;
        this.statusId = statusId;
        this.status = status;
        this.typeId = typeId;
        this.type = type;
    }
}
