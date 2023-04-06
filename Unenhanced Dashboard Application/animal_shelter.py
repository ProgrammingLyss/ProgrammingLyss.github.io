import json
from pymongo import MongoClient
from bson.objectid import ObjectId

class AnimalShelter(object):
    """ CRUD operations for Animal Collection in MongoDB """
    def __init__(self):
        # to connect to mongodb without authentication
        self.client = MongoClient('mongodb://localhost:27017')
        self.database = self.client['AAC']
        
    def create(self, data):
        if data is not None:
            self.database.animals.insert(data)
            return True
        else:
            raise Exception("Data insertion failed.")
            
    def readAll(self, data):
        cursor = self.database.animals.find(data, {'_id':False} )
        return cursor
    
    def read(self, data):
        return self.database.animals.find_one(data, {"animal_type":"Cat", "color":"Black/White"} ) # returns one document as Python dictionary
    
    def update(self, data, change):
        if data is not None:
            return self.database.animals.update(data, {"$set": change})
        else:
            print('Nothing to update.')
            return False
        
    def delete(self, data):
        if data is not None:
            return self.database.animals.delete_one(data)
        else:
            print('Nothing to delete.')
            return False
        
        