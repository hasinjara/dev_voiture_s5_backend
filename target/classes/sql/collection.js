db.createCollection("Conversations", {
    validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["id", "participants"],
        properties: {
          id: {
            bsonType: "long",  // Correction : Utiliser "long" pour l'identifiant de la conversation
            description: "ID de la conversation"
          },
          participants: {
            bsonType: "array",
            description: "Participants de la conversation"
          }
        }
      }
    }
});

db.createCollection("Messages", {
    validator: {
      $jsonSchema: {
        bsonType: "object",
        required: ["sender", "content", "time_created", "conversationId"],
        properties: {
          sender: {
            bsonType: "string",
            description: "Nom du sender (expéditeur)"
          },
          content: {
            bsonType: "string",
            description: "Contenu du message"
          },
          time_created: {
            bsonType: "date",
            description: "Date de création du message"
          },
          conversationId: {
            bsonType: "long",  // Correction : Utiliser "long" pour les identifiants de conversation
            description: "ID de la conversation associée"
          }
        }
      }
    }
});


// Insérer la valeur initiale de l'auto-incrémentation
db.ConversationsSequence.insertOne({
    sequence_value: 1
  });
  
  // Fonction pour obtenir et incrémenter la valeur de l'auto-incrémentation
  function getNextSequenceValue(sequenceName) {
    var sequenceDocument = db.ConversationsSequence.findAndModify({
      query: { _id: sequenceName },
      update: { $inc: { sequence_value: 1 } },
      new: true
    });
  
    return sequenceDocument.sequence_value;
  }
  