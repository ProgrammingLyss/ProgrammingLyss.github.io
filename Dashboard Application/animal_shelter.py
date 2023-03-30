##################################################################################
#                          Dashboard Application                                 #
#                                                                                #
# Description: A dashboard application that works with existing data to identify #
# and categorize available dogs that are good candidates for search-and-rescue   #
# training.                                                                      #
# Alyssa Fasciano                                                                #
# Southern New Hampshire University                                              #
# CS-499: Computer Science Capstone                                              #
# March/April 2023                                                               #
##################################################################################
import json
from pymongo import MongoClient
from bson.objectid import ObjectId

class AnimalShelter(object):
    """ CRUD operations for Animal Collection in MongoDB """
    def __init__(self, username="aacuser", password="abcdef"):
        # to connect to mongodb with authentication
        self.client = MongoClient('mongodb://%s:%s@localhost:27017/?authMechanism=DEFAULT&authSource=AAC'%(username, password))
        self.database = self.client['AAC']
    
    # create method
    def create(self, data):
        if data is not None:
            self.database.animals.insert(data)
            return True
        else:
            raise Exception("Data insertion failed.")
    
    # read all method
    def readAll(self, data):
        cursor = self.database.animals.find(data, {'_id':False} )
        return cursor
    
    # read method
    def read(self, data):
        return self.database.animals.find_one(data, {"animal_type":"Cat", "color":"Black/White"} ) # returns one document as Python dictionary
    
    # update method
    def update(self, data, change):
        if data is not None:
            return self.database.animals.update(data, {"$set": change})
        else:
            print('Nothing to update.')
            return False
    
    # delete method
    def delete(self, data):
        if data is not None:
            return self.database.animals.delete_one(data)
        else:
            print('Nothing to delete.')
            return False
        
        