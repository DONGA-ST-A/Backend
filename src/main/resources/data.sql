-- INSERT MEMBER
INSERT INTO Member (id, userId, email, name, createdDate, modifiedDate) VALUES (1, 'pdohyung', 'pdohyung@naver.com', '도형', now(), now());

INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (1, 'USE', '배터리는 어떻게 교체하나요?', '하이카디 패치의 배터리는 교환이 불가능한 재충전식 내장배터리로 구성되어 있습니다. 방전 후 재충전을 하실 수 있는 충전기를 제공해 드립니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (2, 'DELIVERY', '오늘 주문하면 언제 도착하나요?', '배송은 출고 후 도착까지 보통 1~3일 소요됩니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (3, 'DEVICE', '구매한 패치에 이상이 있습니다.', '패치에 이상이 있으실 경우 1대1 문의를 이용해 주세요.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (4, 'DELIVERY', '배송 완료라고 문자가 왔는데 6시간이 지난 지금까지도 배송되지 않았습니다.', '1대1 문의를 남겨주시면 택배기사님과 연락 후 조치를 취해드리겠습니다.', now(), now());
INSERT INTO Faq (id, category, question, answer, createdDate, modifiedDate) VALUES (5, 'USE', '만 7세 평균 체중 남아에게 사용해도 괜찮을까요?', '사용해도 괜찮습니다.', now(), now());
