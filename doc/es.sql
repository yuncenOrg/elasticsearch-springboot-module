POST /s_subject/_search
{
  "query":{
    "match_all":{}
  }
}


POST /s_subject/_search
{
  "query":{
    "match":{
      "sub_title": "信息"
    }
  }
}


POST /s_subject/_search
{
  "query":{
    "match":{
      "_id": "337"
    }
  }
}

POST /s_subject/_search
{
  "query":{
    "match":{
      "sub_tag":"计算机系统基础"
    }
  }
}




POST /s_subject/_search
{
  "query":{
    "match":{
      "sub_title": "信息"
    }
  },
  "from": 1,
  "size": 2
}


# 高亮
POST /s_subject/_search
{
  "query":{
    "match":{
      "sub_title": "信息"
    }
  },
  "highlight": {
    "fields": {
      "sub_title": {}
    }
  }
}




POST /s_subject/_search
{
  "_source": ["id"],
  "query":{
    "match":{
      "sub_title": "信息"
    }
  },
  "from": 1,
  "size": 10
}

# 只返回部分数据
POST /s_subject/_search
{
  "_source": ["sub_tag","id"],
  "query":{
    "match_all":{

    }
  }
}

# 查询数据总量
POST /s_subject/_search
{
  "query": {
    "match_all": {}
  },
  "aggs": {
    "total_count": {
      "cardinality": {
        "field": "_id"
      }
    }
  }
}



HEAD /s_subject
GET /s_subject
GET _all
GET /_cat/indices?v

POST /s_subject/_open

# DELETE /s_subject

PUT /s_subject
PUT /s_subject/_mapping
{
  "properties":{
    "sub_title":{
      "type":  "text",
      "index": true,
      "store": true,
      "analyzer": "ik_max_word"
    }
  }
}

POST /s_subject/_search
{
  "query":{
    "match_all":{}
  }
}


POST /subject/_search
{
  "query":{
    "match_all":{}
  }
}

GET /s_subject/_mapping

GET /subject/_mapping



PUT /subject
{
  "mappings": {
    "properties": {
      "id": {
        "type": "integer"
      },
      "paper_id" : {
        "type" : "integer"
      },
      "sub_info" :{
        "type": "text",
        "analyzer": "ik_smart"
      },
      "sub_no" :{
        "type": "text",
        "analyzer": "ik_smart"
      },
      "sub_ref" :{
        "type": "text",
        "analyzer": "ik_smart"
      },
      "sub_tag" :{
        "type": "text",
        "analyzer": "ik_smart"
      },
      "sub_title" :{
        "type": "text",
        "analyzer": "ik_smart"
      }
    }
  }
}

# 新旧索引传递数据
POST _reindex
{
  "source": {
    "index": "s_subject"
  },
  "dest": {
    "index": "subject"
  }
}