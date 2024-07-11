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

POST /s_subject/_search
{
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