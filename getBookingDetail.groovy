import org.springframework.cloud.contract.spec.Contract

Contract.make {
    //ignored()
    request {
        method 'GET'
        urlPath('/internalcall/getsubmitdata/2774962371817472') {
            queryParameters {
                parameter 'splitOrderID' : value(consumer(matching("[0-9]+")), producer("2766484749414400"))
            }
        }
        /*url $(consumer(regex('/internalcall/getsubmitdata/[0-9]{5}$')), producer('/internalcall/getsubmitdata/12345')) {
            queryParameters {
                parameter 'splitOrderID' : value(consumer(matching("[0-9]+")), producer("EF0001"))
            }
        }*/
        headers {
            header(authorization(), "fordpass")
            header(contentType(), "application/json")
            header(contentEncoding(),'UTF-8')
            header('transactionalId',  value(consumer(matching("[0-9]{5}")), producer("T0001")))
        }
    }
    response {
        status 200

        body(
                '''
                {
                  "status": {
                    "status_code": "2000200",
                    "message": "Request is processed successfully"
                  },
                  "response_data": {
                    "content": [
                        {
                            "master_order_ID": "49",
                            "product_ID": "2018061101",
                            "bookingDate": "20180705",
                            "comments": "新增",
                            "customerName": "Tom",
                            "customerPhone": "17245678900",
                            "dealerAddress": "上海市金沙江路1899号",
                            "dealerId": "20940",
                            "dealerName": "九和汽车销售有限公司",
                            "dealerPhone": "021-88888888",
                            "mileage": 4500,
                            "orderId": "FP20180703000019",
                            "serviceAdvisor": {
                            "sa_ID": "22111147",
                            "sa_Name" :"22111147"
                            },
                            "serviceType": "维修",
                            "source": "FP",
                            "timeslot": "13:00",
                            "userGuid": "76ee637b-4ca7-4f60-b7ab-b31305ac042e",
                            "vin": "12234234239"
                        }
                    ]
                  }
                }
            '''
        )
        headers {
            header('Content-Type', 'application/json;charset=UTF-8')
        }
    }
}