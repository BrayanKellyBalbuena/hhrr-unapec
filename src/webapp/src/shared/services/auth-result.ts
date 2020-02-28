export interface AuthResult {
    token: string;
    type: string;
    id: number;
    username: string;
    email: string;
    expirationDate: Date;
    roles: string[];
}
