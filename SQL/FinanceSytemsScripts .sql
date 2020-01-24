
 --CARD_TYPE_TABLE

create table card_type 
( card_type_id NUMBER(3),
  card_type VARCHAR2(10),
  card_limit NUMBER(8) NOT NULL,
  card_validity_period NUMBER(2) NOT NULL,
 CONSTRAINT PK_CARD_TYPE PRIMARY KEY(card_type_id));


--CARD_TABLE

create table card
(  card_number NUMBER(16),
   valid_from DATE, --LOOK IT UP
   valid_till DATE,
   credit_used NUMBER(8,2),
   card_type_id NUMBER(3),
   card_status VARCHAR2(1) DEFAULT 'N' ,
   CONSTRAINT check_card_status CHECK(card_status IN( 'Y','N')),
   CONSTRAINT FK_CARD_CARDTYPE FOREIGN KEY (card_type_id) REFERENCES card_type(card_type_id),
   CONSTRAINT PK_CARD PRIMARY KEY(card_number));
	



--PRODUCT_TABLE

create table product  
( product_id NUMBER(7),
  product_code VARCHAR(3),
  product_name VARCHAR2(20) NOT NULL,
  product_processing_fees NUMBER(3) NOT NULL,
  product_price NUMBER(8,2) NOT NULL,
  product_units_in_stock NUMBER(5)NOT NULL,
  product_description VARCHAR2(255) NOT NULL,
  CONSTRAINT PK_PRODUCT PRIMARY KEY(product_id));


  --CUSTOMER TABLE
  
  create table customer
  ( customer_id NUMBER(10),
    customer_name VARCHAR2(20) NOT NULL,
	customer_address VARCHAR2(30) NOT NULL,
    customer_dob DATE NOT NULL,
    customer_email_id VARCHAR2(25) UNIQUE NOT NULL,
    customer_phone_no NUMBER(10)  NOT NULL,
	customer_annual_income NUMBER(8,2) NOT NULL,
    customer_savings_account VARCHAR2(16) NOT NULL,
	customer_ifsc_code VARCHAR2(12) NOT NULL,
	customer_bank_name VARCHAR2(20) NOT NULL,
	customer_approved_status VARCHAR2(1) DEFAULT 'N' , 
	customer_card_number NUMBER(16),
	CONSTRAINT check_valid_approved_status CHECK(customer_approved_status IN( 'Y','N')),
	CONSTRAINT FK_CUSTOMER_CARD FOREIGN KEY(customer_card_number) REFERENCES card(card_number),
	CONSTRAINT PK_CUSTOMER PRIMARY KEY(customer_id));
	--annual income DONE
	
	--LOGIN_TABLE
	
	create table login
	( user_name VARCHAR2(10),
	  password VARCHAR2(8),
	  account_id NUMBER(10),
   	 CONSTRAINT FK_LOGIN_CUSTOMER FOREIGN KEY(account_id) REFERENCES customer(customer_id),
	  CONSTRAINT PK_LOGIN PRIMARY KEY(user_name));
	  
	  
	--EMI_TABLE
	create table emi
	( emi_id NUMBER(10),
	  customer_id NUMBER(10),
	  product_id NUMBER(7),
	  emi_start_date DATE,
	  emi_end_date DATE,
	  total_amount_paid NUMBER(8,2),
	  emi_balance_remaining NUMBER(8,2),
	  amount_each_month NUMBER(6),
	  emi_active_status VARCHAR2(1) DEFAULT 'A', --boolean is not available use check constraint
	  CONSTRAINT check_valid_emi_status CHECK(emi_active_status IN ( 'A' , 'I')), 
	  CONSTRAINT FK_EMI_CUSTOMER FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
	  CONSTRAINT FK_EMI_PRODUCT FOREIGN KEY(product_id) REFERENCES product(product_id),
	  CONSTRAINT PK_EMI PRIMARY KEY(emi_id));
	
	
	--EMI_PAYMENT_TABLE
	create table emi_payment
	( emi_payment_id NUMBER(10),
	  emi_id NUMBER(10),
	  emi_payment_receieved NUMBER(8,2) NOT NULL,
	  emi_payment_receieve_date DATE,
	  emi_payment_ontime VARCHAR2(1) DEFAULT 'N', --boolean is not available use check constraint
	  CONSTRAINT check_emi_payment_ontime CHECK(emi_payment_ontime IN ( 'Y' , 'N')), 
	  CONSTRAINT FK_PAYMENT_EMI FOREIGN KEY(emi_id) REFERENCES emi(emi_id),
	  CONSTRAINT PK_EMI_PAYMENT PRIMARY KEY(emi_payment_id));
	
	
	
	
	--CARD_TYPE_TABLE INSERT
	insert into card_type(card_type_id, card_type, card_limit, card_validity_period)
	 values (1, 'Gold', 50000, 2);
	
	insert into card_type(card_type_id, card_type, card_limit, card_validity_period)
	 values (2, 'Titanium', 100000, 4);
	 
	commit;
	
	--CARD_TABLE INSERT 
	
	insert into card(card_number, credit_used, card_type_id)
	 values (123456, 50000, 1);
	 
	insert into card(card_number, credit_used, card_type_id)
	 values (122411,50000, 1);
	 
	insert into card(card_number, credit_used, card_type_id)
	 values (123412, 100000, 2);
	 
	commit;
	 
	
	--PRODUCT_TABLE INSERT
	
	insert into product(product_id, product_code, product_name, product_processing_fees, product_price, product_units_in_stock, product_description)
	 values (1, 'MOB', 'Redmi Note 8 Pro', 399, 16000, 10, '6GB RAM WITH 128 GB MEMORY' );
	 
	insert into product(product_id, product_code, product_name, product_processing_fees, product_price, product_units_in_stock, product_description)
	 values (2, 'MOB', 'Redmi Note 8 ', 299, 12000, 25, '4GB RAM WITH 64 GB MEMORY' );
	 
	insert into product(product_id, product_code, product_name, product_processing_fees, product_price, product_units_in_stock, product_description)
	 values (3, 'MOB', 'Samsung Galaxy A50s', 399, 24000, 35, '6GB RAM WITH 128 GB MEMORY, INBUILT FRINGERPRINT SCANNER' );
	  
	commit;
	
	
	--CUSTOMER_TABLE INSERT
	
	insert into customer(customer_id, customer_name, customer_address, customer_dob, customer_email_id, customer_phone_no, customer_annual_income, customer_savings_account, customer_ifsc_code, customer_bank_name)
	 values(1, 'Akash', 'Thane', TO_DATE('1997-10-07','YYYY-MM-DD'), 'akashshetty737@gmaill.com', 8454833945, 300000, '312133111221', 'MHB001211', 'Maharashtra Bank');
	
	insert into customer(customer_id, customer_name, customer_address, customer_dob, customer_email_id, customer_phone_no, customer_annual_income, customer_savings_account, customer_ifsc_code, customer_bank_name)
	 values(2, 'Pawan', 'Chennai', TO_DATE('1997-11-17','YYYY-MM-DD'), 'pawan211@gmaill.com', 8121341112, 300000, '993259099012', 'TJSB001211', 'TJSB');
	
	commit;
	
	--EMI_TABLE INSERT
	
	insert into emi (emi_id, customer_id, product_id, emi_start_date, emi_end_date, total_amount_paid, emi_balance_remaining, amount_each_month)
	 values(1, 1, 2, TO_DATE('2020-2-4','YYYY-MM-DD'), TO_DATE('1997-8-4','YYYY-MM-DD'), 0, 16000, 2733);


	--PAYMENT_TABLE INSERT
	
	insert into emi_payment(emi_payment_id, emi_id, emi_payment_recieved, emi_payment_recieve_date, emi_payment_ontime)
	 values(1, 1, 2733, TO_DATE(SYSDATE,'YYYY-MM-DD'), 'Y')
	 
	select * from card_type;
	select * from card;
	select * from customer;
	select * from emi;
	select * from product;
	select * from emi_payment;


	 create sequence customer_seq
  2  increment by 1
  3  start with 1
  4  maxvalue 10000
  5  nocycle
  6  nocache;