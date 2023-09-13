-- INSERT MEMBER
INSERT INTO Member (id, userId, email, name, createdDate, modifiedDate) VALUES (1, 'pdohyung', 'pdohyung@naver.com', '도형', now(), now());

INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (1, 'USE', '배터리는 어떻게 교체하나요?', '하이카디 패치의 배터리는 교환이 불가능한 재충전식 내장배터리로 구성되어 있습니다. 방전 후 재충전을 하실 수 있는 충전기를 제공해 드립니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (2, 'DELIVERY', '오늘 주문하면 언제 도착하나요?', '배송은 출고 후 도착까지 보통 1~3일 소요됩니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (3, 'DEVICE', '구매한 패치에 이상이 있습니다.', '패치에 이상이 있으실 경우 1대1 문의를 이용해 주세요.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (4, 'DELIVERY', '배송 완료라고 문자가 왔는데 6시간이 지난 지금까지도 배송되지 않았습니다.', '1대1 문의를 남겨주시면 택배기사님과 연락 후 조치를 취해드리겠습니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (5, 'USE', '만 7세 평균 체중 남아에게 사용해도 괜찮을까요?', '사용해도 괜찮습니다.', now(), now());

INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (1, '하이카디플러스 HiCardi+', '편리하게 심전도 측정, 전송 및 분석', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview1.svg', 2046000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (2, '하이카디플러스 HiCardi+ H100', '메모리 내장형 제품', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview2.svg', 1320000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (3, '하이카디 HiCardi', '편리하게 심전도 측정, 전송 및 분석', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview3.svg', 1496000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (4, '심전도 전극 리필, 소형 20매', 'ECG Electrodes - standard', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview4.svg', 16500, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (5, '심전도 전극 리필, 대형 20매', '메모리 내장형 제품', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview5.svg', 22000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (6, '노닌 펄스옥시미터 3150', '하이카디 플러스와 연동이 가능한 손목밴드형 산소포화도 측정 장비', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview6.svg', 1540000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (7, '노닌 펄스옥시미터 3230', '하이카디 플러스와 연동이 가능한 클립형 산소포화도 측정 장비', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview7.svg', 550000, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (8, '원격 판독권', '부정맥 전문의 원격 판독 서비스', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview8.svg', null, 100, 'SELL', now(), now());
INSERT INTO Item (id, name, subname, previewImage, price, stock, status, createdDate, modifiedDate) VALUES (9, '갤럭시 A13', '하이카디 서비스에 필요한 스마트폰(미개통)', 'https://hicardi.s3.ap-northeast-2.amazonaws.com/preview9.svg', 275000, 100, 'SOLD_OUT', now(), now());

INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (1, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage1.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (2, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage2.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (3, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage3.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (4, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage4.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (5, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage5.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (6, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage6.svg', 1, now(), now());
INSERT INTO ItemImage(id, image, itemId, createdDate, modifiedDate) VALUES (7, 'https://hicardi.s3.ap-northeast-2.amazonaws.com/itemImage7.svg', 1, now(), now());

INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(1, 1, 'SmartPatch', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(2, 1, 'DeviceBody', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(3, 2, 'SmartPatch', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(4, 2, 'DeviceBody', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(5, 3, 'SmartPatch', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(6, 3, 'DeviceBody', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(7, 4, 'HicardiOnly', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(8, 4, 'AdditionalItem', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(9, 5, 'HicardiPlusOnly', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate)  VALUES(10, 5, 'AdditionalItem', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(11, 6, 'OxygenMeasurement', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(12, 6, 'AdditionalItem', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(13, 7, 'OxygenMeasurement', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(14, 7, 'AdditionalItem', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(15, 8, 'RemoteReading', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(16, 8, 'AdditionalService', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(17, 9, 'SmartPhone', NOW(), NOW());
INSERT INTO ItemTag (id, itemId, Tag, createdDate, modifiedDate) VALUES(18, 9, 'AdditionalItem', NOW(), NOW());




