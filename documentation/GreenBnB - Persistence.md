# Item
    "Item": {
      "type": "object",
      "properties": {
        "id_servicio": {
          "type": "integer",
          "format": "int64"
        },
        "quantity": {
          "type": "integer",
          "format": "int64"
        }
      },
      "xml": {
        "name": "Item"
      }
    }

# Cart
    "Cart": {
      "type": "object",
      "properties": {
        "id": {
          "type": "integer",
          "format": "int64"
        },
        "items": {
          "type": "array",
          "items": {
            "$ref": "#/definitions/Item"
          }
        }
      },
      "xml": {
        "name": "Cart"
      }
    }

# Question
    "Question": {
      "type": "object",
      "properties": {
        "id_user": {
          "type": "integer",
          "format": "int64"
        },
        "question": {
          "type": "string"
        },
        "answer": {
          "type": "string"
        },
        "id_question": {
          "type": "integer",
          "format": "int64"
        },
        "id_client": {
          "type": "integer",
          "format": "int64"
        },
        "id_service": {
          "type": "integer",
          "format": "int64"
        },
        "date": {
          "type": "string",
          "format": "date-time"
        }
      },
      "xml": {
        "name": "Question"
      }
    }

# Review
    "Review": {
      "type": "object",
      "properties": {
        "id_user": {
          "type": "integer",
          "format": "int64"
        },
        "comment": {
          "type": "string"
        },
        "score": {
          "type": "integer",
          "minimum": 1,
          "maximum": 5
        }
      }
    }

# Service
    "Service": {
      "type": "object",
      "properties": {
        "id_service": {
          "type": "integer",
          "format": "int64"
        },
        "id_supplier": {
          "type": "integer",
          "format": "int64"
        },
        "category": {
          "type": "string"
        },
        "name": {
          "type": "string"
        },
        "start_date": {
          "type": "string",
          "format": "date-time"
        },
        "end_date": {
          "type": "string",
          "format": "date-time"
        },
        "reviews": {
          "type": "array",
          "items": {
            "$ref": "#/definitions/Review"
          }
        },
        "questions": {
          "type": "array",
          "items": {
            "$ref": "#/definitions/Question"
          }
        }
      }
    }

# Client
    "Client": {
      "type": "object",
      "properties": {
        "id_client": {
          "type": "integer",
          "format": "int64"
        },
        "username": {
          "type": "string"
        },
        "firstName": {
          "type": "string"
        },
        "lastName": {
          "type": "string"
        },
        "email": {
          "type": "string"
        },
        "password": {
          "type": "string"
        },
        "age": {
          "type": "integer",
          "format": "int32"
        },
        "photo": {
          "type": "string"
        }
      }
    }

# Supplier
    "Supplier": {
      "type": "object",
      "properties": {
        "id_supplier": {
          "type": "integer",
          "format": "int64"
        },
        "username": {
          "type": "string"
        },
        "firstName": {
          "type": "string"
        },
        "lastName": {
          "type": "string"
        },
        "email": {
          "type": "string"
        },
        "password": {
          "type": "string"
        },
        "age": {
          "type": "integer",
          "format": "int32"
        },
        "photo": {
          "type": "string"
        },
        "website": {
          "type": "string"
        },
        "contact": {
          "type": "string"
        }
      }
    }

# Credential
    "Credential": {
      "type": "object",
      "properties": {
        "username": {
          "type": "string"
        },
        "password": {
          "type": "string"
        }
      }
    }

# Session
    "Session": {
      "type": "object",
      "properties": {
        "session_id": {
          "type": "string"
        },
        "token": {
          "type": "string"
        }
      }
    }

# Order
    "Order": {
      "type": "object",
      "required": [
        "id_order",
        "payment_method",
        "date",
        "total",
        "currency",
        "order_items"
      ],
      "properties": {
        "id_order": {
          "type": "string",
          "format": "int32",
          "example": 1
        },
        "id_client": {
          "type": "string",
          "format": "int32",
          "example": 1
        },
        "payment_method": {
          "type": "string",
          "enum": [
            "COP",
            "USD",
            "CNY",
            "JPY",
            "HKD",
            "GBP",
            "EUR"
          ]
        },
        "date": {
          "type": "string",
          "format": "date-time",
          "example": "2016-08-29T09:12:33.001Z"
        },
        "total": {
          "type": "number",
          "example": 99.99
        },
        "currency": {
          "type": "string",
          "enum": [
            "CreditCard",
            "DebitCard",
            "ElectronicBankTransfers"
          ]
        },
        "oder_items": {
          "type": "array",
          "items": {
            "$ref": "#/definitions/Item"
          }
        }
      }
    }
