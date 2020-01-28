import { Customer } from './customer';
import { Product } from './product';

export class Emi {

        emiId : number;
		emiStartDate : string;
		emiEndDate : string;
		totalAmountPaid : number;
		emiBalanceRemaining : number;
		amountEachMonth : number;
        emiActiveStatus : string;
        customer : Customer;
        product : Product;
}
