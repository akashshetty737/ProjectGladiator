import { Card } from './card';

export class Customer{
    customerId: number;
    customerName: string;
    customerAddress: string;
    customerDob: string;
    customerEmailId: string;
    customerPhoneNo: number;
    customerAnnualIncome : number;
    customerSavingsAccount:string;
    customerIfscCode:string;
    customerBankName: string;
    customerApprovedStatus:string;
    customerCard: Card;
}