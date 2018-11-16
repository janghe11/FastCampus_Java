-- Category Sample Data
INSERT INTO category(name) VALUES ("Language");
INSERT INTO category(name) VALUES ("DBMS");
INSERT INTO category(name) VALUES ("Tool");
INSERT INTO category(name) VALUES ("인프라");
INSERT INTO category(name) VALUES ("CI/CD");
INSERT INTO category(name) VALUES ("DevOps");
INSERT INTO category(name) VALUES ("Framework");
INSERT INTO category(name) VALUES ("Community");

-- ExpireType
INSERT INTO expire_type(name) VALUES ("기한 만료");
INSERT INTO expire_type(name) VALUES ("임의 사용 불가");

-- Coupon Sample Data
INSERT INTO coupon(name, total_qty, cur_qty, sale_money, sale_ratio, free_shipping,reg_date, expire_date, duration_period, expire_type_id, description) VALUES ("신규 가입 쿠폰", 5000, 5000, 1000, 0.0, false, now(), null, 30, 1, "회원 첫 가입 감사 쿠폰(30일간 사용 가능)");
INSERT INTO coupon(name, total_qty, cur_qty, sale_money, sale_ratio, free_shipping,reg_date, expire_date, duration_period, expire_type_id, description) VALUES ("할로윈 데이 쿠폰", 1000, 999, 0, 0.05, false, now(), null, 30, 1, "할로윈 데이 11월 쿠폰");

-- Image Sample Data

-- MemberGrade Sample Data
INSERT INTO member_grade(name, sale_money, sale_ratio) VALUES ("Welcome", 0, 0.0);
INSERT INTO member_grade(name, sale_money, sale_ratio) VALUES ("Bronze", 0, 0.01);
INSERT INTO member_grade(name, sale_money, sale_ratio) VALUES ("Silver", 0, 0.05);
INSERT INTO member_grade(name, sale_money, sale_ratio) VALUES ("Gold", 0, 0.1);
INSERT INTO member_grade(name, sale_money, sale_ratio) VALUES ("Admin", 0, 0.0);

-- OrderStatus Sample Data
INSERT INTO order_status(name) VALUES ("입금 확인 전");
INSERT INTO order_status(name) VALUES ("결제 확인");
INSERT INTO order_status(name) VALUES ("상품 준비 중");
INSERT INTO order_status(name) VALUES ("배송 준비 중");
INSERT INTO order_status(name) VALUES ("배송 중");
INSERT INTO order_status(name) VALUES ("배송 완료");
INSERT INTO order_status(name) VALUES ("구매 확정");

-- Role Sample Data
INSERT INTO role(name) VALUES ("읽기");
INSERT INTO role(name) VALUES ("쓰기");
INSERT INTO role(name) VALUES ("관리자");

-- ShippingInfo Sample Data
INSERT INTO shipping_info(user_name, zip_code, addr, phone, shipping_fee, memo) VALUES ("장태희", 11709, "경기도 의정부시 안말로85번길", "010-9976-9905", 2500, "부재시 경비실에 맡겨주세요");

-- Member Sample Data
INSERT INTO member(id, user_name, email, password, nick_name, addr, zip_code, phone, mileage, member_grade_id, reg_date, mod_date) VALUES ("admin", "관리자", "admin@test.net", "admin", "관리자", "서울시 광진구", 11111, "02-123-4567", 0, 5, now(), now());
INSERT INTO member(id, user_name, email, password, nick_name, addr, zip_code, phone, mileage, member_grade_id, reg_date, mod_date) VALUES ("jang", "장태희", "jang@test.net", "1234", "장태희1", "경기도 의정부시", 22222, "031-890-1234", 0, 1, now(), now());

-- MemberCoupon Sample Data
INSERT INTO member_coupon(member_id, coupon_id, order_info_id, reg_date, expire_date, used_check) VALUES ("jang", 1, null, now(), null, 0);

-- Product Sample Data
INSERT INTO product(name, price, total_qty, cur_qty, mileage) VALUES ("우분투 스티커", 1000, 999, 0, 10);
INSERT INTO product(name, price, total_qty, cur_qty, mileage) VALUES ("오픈스택 스티커", 1500, 100, 0, 15);
INSERT INTO product(name, price, total_qty, cur_qty, mileage) VALUES ("파이썬 스티커", 2000, 150, 0, 20);
INSERT INTO product(name, price, total_qty, cur_qty, mileage) VALUES ("파이콘 스티커", 1000, 150, 0, 10);

-- OrderInfo Sample Data
INSERT INTO order_info(member_id, total_price, order_date, order_status, shipping_info) VALUES ("jang", 20000, now(), 2, 1);

-- OrderInfoProduct Sample Data
INSERT INTO order_info_product(order_info_id, product_id, name, quantity, price, mileage) VALUES (1, 2, "오픈스택 스티커", 10, 1500, 15);
INSERT INTO order_info_product(order_info_id, product_id, name, quantity, price, mileage) VALUES (1, 4, "파이콘 스티커", 5, 1000, 10);

-- CartProduct Sample Data
INSERT INTO cart_product(member_id, product_id, quantity) VALUES ("jang", 2, 5);
INSERT INTO cart_product(member_id, product_id, quantity) VALUES ("jang", 1, 10);
INSERT INTO cart_product(member_id, product_id, quantity) VALUES ("jang", 3, 4);